const {createHash} = require('crypto')
const {protobuf} = require('sawtooth-sdk')
const {createContext, CryptoFactory} = require('sawtooth-sdk/signing')
const {Secp256k1PrivateKey} = require('sawtooth-sdk/signing/secp256k1')
const request = require('request');

function handlerInfo(){
  const familyName = 'onlinevoting';
  return {
            prefix : getAddress(familyName, 6),
            family : familyName,
            version :'0.0.1'
        };
}

function getAddress(key, length) {
  return createHash('sha512').update(key).digest('hex').slice(0, length)
}

function calculateVoteAddress(payload) {
  return handlerInfo().prefix + getAddress(payload.ellectionName,20) + getAddress(payload.userNumber,20) + getAddress(payload.address,24);
}

const getAssetAddress = payload => handlerInfo().prefix + getAddress(payload.ellectionName,20) + getAddress(payload.userNumber,20) + getAddress(payload.address,24)

function sendToSawtoothApi(batchBytes) {
  request({
      url: 'http://localhost:8008/batches?wait',
      method: 'POST',
      body: batchBytes,
      encoding: null,
      headers: {'Content-Type': 'application/octet-stream'}
    }, (error, response, body) => {
      if (error) {
        console.log(error);
      } else {
        const res = new Buffer(response.body, 'base64').toString()
        console.log('Response: ', res);
      }
    })
}

function buildSawtoothPackage(payloadBytes,privateKey){

  const context = createContext('secp256k1');
  const privateKeyInstance = Secp256k1PrivateKey.fromHex(privateKey);
  const signer = new CryptoFactory(context).newSigner(privateKeyInstance);

  const {family,version,prefix} = handlerInfo();

  const transactionHeaderBytes = protobuf.TransactionHeader.encode({
    familyName: family,
    familyVersion: version,
    inputs: [prefix],
    outputs: [prefix],
    signerPublicKey: signer.getPublicKey().asHex(),
    batcherPublicKey: signer.getPublicKey().asHex(),
    payloadSha512: createHash('sha512').update(payloadBytes).digest('hex')
  }).finish();

  const signature = signer.sign(transactionHeaderBytes);

  const transaction = protobuf.Transaction.create({
      header: transactionHeaderBytes,
      headerSignature: signature,
      payload: payloadBytes
  });

  const batchHeaderBytes = protobuf.BatchHeader.encode({
      signerPublicKey: signer.getPublicKey().asHex(),
      transactionIds: [transaction.headerSignature],
  }).finish();

  const batchSignature = signer.sign(batchHeaderBytes);

  const batch = protobuf.Batch.create({
      header: batchHeaderBytes,
      headerSignature: batchSignature,
      transactions: [transaction]
  });

  const batchBytes = protobuf.BatchList.encode({
      batches: [batch]
  }).finish();

  return batchBytes;
}

module.exports = { buildSawtoothPackage,sendToSawtoothApi,handlerInfo,calculateVoteAddress}
