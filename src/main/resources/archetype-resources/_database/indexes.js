var showIndexes = function (collectionName) {
    printjson(db[collectionName].getIndexes());
};

var createIndexes = function () {
    showIndexes();
};