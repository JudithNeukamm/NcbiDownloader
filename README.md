# NcbiDownloader
This tool parses a SraRunTable file and creates a bash file to download all samples. 

Input: \
Tab-separated SraRunTable text file, which can be downloaded from the expanded interactive table view on ncbi 
(example: https://www.ncbi.nlm.nih.gov/Traces/study/?WebEnv=NCID_1_34176922_130.14.22.33_5555_1512212844_1998486784_0MetA0_S_HStore&query_key=4) 


Output: \
Bash file that creates new folder for the BioProject and one folder per run. It also separated single-end and
paired-end sequenced files. In case of paired-end sequencing, '_R1' and '_R2' is added to the file name, respectively.

How to run:\
Either run the code itself or build a jar file, that can be run as follows:

*java -jar NcbiDownloader.jar </absolute/path/to/SraInfoTable.txt> </absolute/path/tp/output>*  
