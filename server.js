const express = require('express');
const bodyParser = require('body-parser');
const app = express();
app.set('view engine', 'ejs');
app.use(express.static('public'));
app.use(bodyParser.urlencoded({ extended: true }));

app.get('/', function (request, result) {
  result.render('home');
})

app.post('/', function (request, result) {
  result.render('home');
  console.log(request.body.breedName);
})

//app.welcome('/', function (name, res){
//  window.alert("Welcome to PawMD!");
//})

app.listen(8080, function () {
  console.log('Example app listening on port 8080!')
})
