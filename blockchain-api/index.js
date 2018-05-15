var restify = require('restify');

const {registerBlockchain} = require('./sawtooth/client');

function registerVote(req, res, next) {
  const voto = req.body;
  registerBlockchain(voto);

  res.send(200);
  next();
}

var server = restify.createServer();
server.use(restify.plugins.acceptParser(server.acceptable));
server.use(restify.plugins.bodyParser());

server.post('/register/vote', registerVote);

server.listen(8084, function() {
  console.log('%s listening at %s', server.name, server.url);
});
