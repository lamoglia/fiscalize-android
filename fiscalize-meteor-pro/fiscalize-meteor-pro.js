fiscalizacoes = new MysqlSubscription('allFiscalizacoes');

if (Meteor.isClient) {

  Template.fiscalizacoes.helpers({
    fiscalizacoes: function () {
      return fiscalizacoes.reactive();
    }
  });

}

if (Meteor.isServer) {
  Meteor.startup(function () {
    // code to run on server at startup
  });
}

if (Meteor.isServer) {

  var liveDb = new LiveMysql({
    host: 'localhost',
    // Port 3407 as specified in leaderboard.mysql.json
    // If using external MySQL server, the default port is 3306
    port: 3306,
    user: 'root',
    password: 'saph2mil',
    database: 'fiscalizepro'
  });

  var closeAndExit = function () {
    liveDb.end();
    process.exit();
  };
  // Close connections on hot code push
  process.on('SIGTERM', closeAndExit);
  // Close connections on exit (ctrl + c)
  process.on('SIGINT', closeAndExit);

  Meteor.publish('allFiscalizacoes', function () {
    return liveDb.select(
        'SELECT * FROM Fiscalizacao',
        [{table: 'Fiscalizacao'}]
    );
  });

}
