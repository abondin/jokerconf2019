create TABLE if not exists RECEIPT (
	UUID varchar(30) PRIMARY KEY,
	TAXPAYER_INN varchar(12) NOT NULL,
	AMOUNT DECIMAL(17, 4) NOT NULL
);
