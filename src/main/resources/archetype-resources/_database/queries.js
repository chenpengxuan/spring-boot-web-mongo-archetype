var check = function (collectionName) {
    var nbOfRecords = db[collectionName].count();
    print(nbOfRecords + ' record(s) found.');

    if (nbOfRecords > 0) {
        printjson(db[collectionName].findOne());
    }
};