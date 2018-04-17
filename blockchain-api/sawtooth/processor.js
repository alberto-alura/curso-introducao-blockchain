'use strict'

const { TransactionProcessor } = require('sawtooth-sdk/processor');
const VALIDATOR_URL = 'tcp://localhost:4004';

module.exports = (handler) => {
  const tp = new TransactionProcessor(VALIDATOR_URL)
  tp.addHandler(handler)
  tp.start()
}
