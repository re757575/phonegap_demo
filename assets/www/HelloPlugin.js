var HelloPlugin = { 
    callNativeFunction: function (success, fail, resultType) { 
      return cordova.exec( success, fail, 
                           "HelloPlugin", 
                           "nativeAction", [resultType]); 
    } 
};