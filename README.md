# Research on Cloud Computing Cost Reduction and Waste Reduction
Research on Cloud Waste and overspending reasons, Engineered Recommendation Algorithm to help users find the best virtual machine specifications. 
All research is based on the public data set released by Microsoft Azure linked here: 
https://github.com/Azure/AzurePublicDataset/blob/master/AzurePublicDatasetLinksV2.txt
We used the data from the vmtable in order to come up with our research recommendation algorithm and conclusions on cloud waste and overspending reasons. 
Usage of java code:
processing.java was used to add the VM waste based on the equation we modeled. (1 - avgCPU/100)*cost)
javatester.java and sotryioranking were used to determine the rankings of the VM waste
SecondFinalProcessing.java was used to compare the different parameters so we could identify VMs that had considerable waste and cost impact towards users.
FinalProcessing.java was used to determine a list of wasted VMs we identified and showed the recommended specifications along with the saved costs if using the recommended specifications. 
