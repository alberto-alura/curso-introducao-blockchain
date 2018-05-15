'use strict'

const cbor = require('cbor')
const {buildSawtoothPackage,sendToSawtoothApi} = require('./infra');

const registerBlockchain = (payload) => {
  console.log(payload);

  const payloadBytes = cbor.encode(JSON.stringify(payload));

  const batchBytes = buildSawtoothPackage(payloadBytes,payload.userNumber);

  sendToSawtoothApi(batchBytes);
}

module.exports = { registerBlockchain }
