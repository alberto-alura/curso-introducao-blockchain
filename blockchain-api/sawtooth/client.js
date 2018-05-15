'use strict'

const cbor = require('cbor')
const {buildSawtoothPackage,sendToSawtoothApi} = require('./infra');

const registerBlockchain = (payload) => {
  console.log(payload);
}

module.exports = { registerBlockchain }
