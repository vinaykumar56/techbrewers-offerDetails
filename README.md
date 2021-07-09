# techbrewers-offerDetails


This service will expose the below methods to interact with offer_db of CLOUNDANTDB

1.  HTTP GET method : To get all offers present in DB
     
    URI - /techbrewers/offers/get


2.  HTTP POST method: To add new entry of offer
    
    URI - /techbrewers/offers/add
    


POST : sample message :-

[

{
"offerId": 1,
"category": "Travel",
"description": "10 percent Discount on booking Air India flight ticket using NBS Debit card"
},

{
"offerId": 4,
"category": "Savings",
"description": "Open a xyz saving account with NBS"
},

{
"offerId": 3,
"category": "Shopping",
"description": "xyz offer with NBS credit card"
},

{
"offerId": 2,
"category": "Travel",
"description": "10 dollar cashback on booking OYYO hotel Rooms using NBS Debit card"
},

{
"offerId": 6,
"category": "Groceries",
"description": "5 dollar cashback on groffers using NBS Debit card"
}

]