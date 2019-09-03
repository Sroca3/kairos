const moment = require('moment');
const fs = require('fs');
var testCaseCounter = 1;
let TEST_FILE_NAME = "test_cases";

setupTestCaseFile();

addTestCase("YYYY/MM/DD");
addTestCase("DD/MM/YYYY");
addTestCase("MM/DD/YYYY");
addTestCase("DD/MM/YY");
addTestCase("MM/DD/YY");
addTestCase("HH:mm");
addTestCase("hh:mm A");

function setupTestCaseFile() {
    if (fs.existsSync(TEST_FILE_NAME)) {
        fs.unlink(TEST_FILE_NAME, (err) => {
            if (err) {
                throw err;
            }
        });
    }
}

function addTestCase(format, unixTimestamp) {
    if (!unixTimestamp) {
        unixTimestamp = moment().utc().valueOf();
    }
    let testCaseData = "Test Case #" + testCaseCounter + ": " +
        moment(unixTimestamp).utc().valueOf() + ", " +
        format + ", " +
        moment(unixTimestamp).utc().format(format);
    console.log(testCaseData);
    fs.appendFile(TEST_FILE_NAME, testCaseData + "\n", (err) => {
        if (err) {
            throw err;
        }
    });
    testCaseCounter++;
}