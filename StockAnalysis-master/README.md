# StockAnalysis

## Analysis and Implementation:

```
Summary: The program will generate top 5 stocks for each market (Japan and Hong Kong in our case) by Short Ratio. Short Ratio is a percentage of outstanding short positions over total outstanding shares for a given stock. It is an indication of how heavily the stock has been shorted (and still not covered or bought back) relative to the outstanding (listed) shares.

We crawled data from Securities and Futures Commission and Tokyo Stock Exchanges website. 

[The structure of the codes written can be found here:](https://drive.google.com/file/d/153fIDL1SUanaRQXuSMo0BKOCHfxXul-y/view?usp=sharing)

[Video link:](https://drive.google.com/file/d/1y0z7eSSO_Np3bhwzrGK3AHJ6hzIZw5rB/view?usp=sharing)
```

### Information contained in the disclosure:
### Japan short selling Exchange disclosure:

> TSE published daily outstanding short selling positions for designated securities through its website (publication on a > daily basis, no data is published for bank holiday)

##### Information contained in the disclosure:
```
Date of disclosure, Date of calculation (notice here data of disclosure is normally 1-2 days later than data of calculation )
> Example: If you want to get all short selling reported occurred on March 29th (Friday), you should get both Apr 1st and Apr 2nd disclosure file and filter out data of calculation to be March 29th 
> Direct:
•	Stock code
•	Number of Short Positions in Shares (need to aggregate various short seller to get the total number)
•	Ratio of Short Positions to Shares Outstanding (need to aggregate various short sell to get the total ratio)
Can be calculate with two week’s data:
•	Short positions % change over the week 
•	Net long/short amount of share change over the week 
```
### Hong Kong short selling Exchange disclosure:
```
The exchange published aggregated reportable short positions of specified shares as of each Friday market close for short sell eligible stocks (publication on a weekly basis, if Friday is a bank holiday, then data on previous trading date will be used)
Information contained in the disclosure:
Direct : 
•	Stock code
•	Aggregated Reportable Short Positions (Shares)
•	Aggregated Reportable Short Positions (HK$)
Indirect：
•	Friday stock market close price
Can be calculate with two week’s data:
•	Stock return over the week (based on Friday market close price)
•	Short positions % change over the week 
•	Net long/short amount of share change over the week 
Can be further calculated with external data- total outstanding shares for each stock (assuming no change in year 2019)
•	Short selling ratio= short positions/total outstanding shares 
Objective：
To generate two data files for a particular Friday (one for HKEX, one for JPX) containing the following data for further DLT processing 
Example： Choose April 12th 2019 as the analysis date
```

#### HK SFC web data processing 
```
1.	Crawl April 12th data from SFC website
2.	Use the total outstanding shares CSV file
3.	Generate a consolidated data file containing the following variables：

•	Calculation Date (should be April 12th for all)
•	Stock code
•	Aggregated Reportable Short Positions (Shares)
•	Ratio of Short Positions to Shares Outstanding
•	Short positions % change over the week 
•	Net long/short amount of share change over the week 
•	Ratio of Short Positions to Shares Outstanding change over the week 
•	Total outstanding shares of the stock
```

#### Japan TSE web data processing
```
1.	Crawl April 16th reports ( Mon and Tues following April 12th ) 
2.	Extract from each file the short selling disclosure on Calculation Date April 12th , aggregate by stock ticker the Number of Short Positions in Shares and Ratio of Short Positions to Shares Outstanding
3.	To generate a new file for April 12th short selling with following variables
o	Stock code
o	Aggregated Reportable Short Positions (Shares)
o	Ratio of Short Positions to Shares Outstanding
o	Total outstanding shares of the stock
4.	Repeat step 1-3 for April 8th and Aril 9th for prepare April 5th (past week) data
5.	Generate a consolidated data file containing the following variables：

•	Calculation Date (should be April 16th for all)
•	Stock code
•	Aggregated Reportable Short Positions (Shares)
•	Ratio of Short Positions to Shares Outstanding
•	Short positions % change over the week 
•	Net long/short amount of share change over the week 
•	Ratio of Short Positions to Shares Outstanding change over the week 
•	Total outstanding shares of the stock
(https://www.jpx.co.jp/english/markets/public/short-selling/b5b4pj000002t7nl-att/20190426_Short_Positions.xls)
```
##### Compiling
```
* HK_outstanding_shares.csv file must be in the right path (in the /HK/ folder) for it to compile
```
