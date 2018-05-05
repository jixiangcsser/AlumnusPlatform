module.exports = function(app, wss) {
    
        if (!app) throw new Error('Must provide express instance.');
        var expressRest = require('express-rest');

        var db = require('./config/mongoose')();
    
        //增加对 json的支持
        var rest = expressRest(app, {
            serializers: {
                'application/json': {
                    deserialize: function(req, res, next) {
                        next();
                    },
                    serialize: function(req, res, next) {
                        next();
                    }
                }
            }
        });
    
    
        rest = require('./learnware/api.js')(rest, app, wss);
    
    
        return rest;
    
    };