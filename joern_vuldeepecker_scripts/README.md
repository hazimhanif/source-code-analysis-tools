# Extraction tools & Scripts

### joern_extract_function.sc  

A Scala script to extract each function from a C source code file using Joern. Each function will be in a separate file. A `metadata.csv` file will be created to store the origin information of the file. Metada includes:  

* Output filename  
* Original filename  
* Line start in the original file  
* Line end in the original file  


### process_joern_vuldeepecker.ipynb  

Jupyter script to process the Joern extracted functions from Vuldeepecker dataset.  
It will also parse the function using Clang python bindings.  