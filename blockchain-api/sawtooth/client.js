'use strict'

const cbor = require('cbor')
const {buildSawtoothPackage,sendToSawtoothApi} = require('./infra');

const registerBlockchain = (privateKey,payload) => {
  console.log(privateKey);
}

module.exports = { registerBlockchain }
