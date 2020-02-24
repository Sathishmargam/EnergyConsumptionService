# EnergyConsumptionService

1.It has 3 services implmented "/counter_callback" will store the consumption details for the village over h2 database.
2. Its a post call and the input parameters in the body will be {
	
	  "counterId":"3",
	  "consumptionAmount":"234",
	  "villageName":"adssdadad"
    }
3. Another end point "/getInfo" will provide you the info from Zenhomes endpoint by accepting the 'CounterNumber' as input in headers.
4. 3rd end point "/consumption_report" will provide the list of consumptionAmounts from h2 db.
5. The endpoint 'https://europe-west2-zenhomes-development-project.cloudfunctions.net/counters/1' is not providing any info regarding the 'ConsumptonAmount',
    so i implmented this way, please let me know which i should consider as the ConsumptionAmount from the API output so that i can implement the same.
