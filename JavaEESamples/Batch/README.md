## Batch Demo

For batchlet demo, simply deploy batch.war to Payara server. You will observe the batchlet process happening every 30 seconds in the server logs. This is in the form of "Processed at ..." messages

You will also observe numbers being outputted every 30 seconds. This is the chunk job and is converting all text in input.txt to capitals and output the value to output.txt. The number is the length of the file from the chunk batchlet.

If you want to run this some strings in Constants will need to be changed.

