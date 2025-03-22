package com.credable.app.middleware_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private String accountNumber;
    private BigDecimal alternativechanneltrnscrAmount;
    private int alternativechanneltrnscrNumber;
    private BigDecimal alternativechanneltrnsdebitAmount ;
    private int alternativechanneltrnsdebitNumber ;
    private int atmTransactionsNumber;
    private BigDecimal atmtransactionsAmount ;
    private int bouncedChequesDebitNumber;
    private int bouncedchequescreditNumber ;
    private BigDecimal bouncedchequetransactionscrAmount ;
    private BigDecimal bouncedchequetransactionsdrAmount ;
    private BigDecimal chequeDebitTransactionsAmount;
    private int chequeDebitTransactionsNumber ;
    private long createdAt;
    private long createdDate;
    private BigDecimal credittransactionsAmount ;
    private BigDecimal debitcardpostransactionsAmount ;
    private int debitcardpostransactionsNumber ;
    private BigDecimal fincominglocaltransactioncrAmount;
    private Long id ;
    private BigDecimal incominginternationaltrncrAmount ;
    private int incominginternationaltrncrNumber;
    private int incominglocaltransactioncrNumber ;
    private BigDecimal intrestAmount ;
    private long lastTransactionDate ;
    private String lastTransactionType;
    private BigDecimal lastTransactionValue ;
    private BigDecimal maxAtmTransactions;
    private BigDecimal maxMonthlyBebitTransactions ;
    private BigDecimal maxalternativechanneltrnscr ;
    private BigDecimal maxalternativechanneltrnsdebit ;
    private BigDecimal maxbouncedchequetransactionscr;
    private BigDecimal maxchequedebittransactions;
    private BigDecimal maxdebitcardpostransactions ;
    private BigDecimal maxincominginternationaltrncr ;
    private BigDecimal maxincominglocaltransactioncr ;
    private BigDecimal maxmobilemoneycredittrn ;
    private BigDecimal maxmobilemoneydebittransaction ;
    private BigDecimal maxmonthlycredittransactions ;
    private BigDecimal maxoutgoinginttrndebit ;
    private BigDecimal maxoutgoinglocaltrndebit ;
    private BigDecimal maxoverthecounterwithdrawals ;
    private BigDecimal minAtmTransactions ;
    private BigDecimal minMonthlyDebitTransactions ;
    private BigDecimal minalternativechanneltrnscr ;
    private BigDecimal minalternativechanneltrnsdebit ;
    private BigDecimal minbouncedchequetransactionscr;
    private BigDecimal minchequedebittransactions ;
    private BigDecimal mindebitcardpostransactions ;
    private BigDecimal minincominginternationaltrncr ;
    private BigDecimal minincominglocaltransactioncr ;
    private BigDecimal minmobilemoneycredittrn;
    private BigDecimal minmobilemoneydebittransaction ;
    private BigDecimal minmonthlycredittransactions ;
    private BigDecimal minoutgoinginttrndebit ;
    private BigDecimal minoutgoinglocaltrndebit ;
    private BigDecimal minoverthecounterwithdrawals;
    private BigDecimal mobilemoneycredittransactionAmount ;
    private int mobilemoneycredittransactionNumber ;
    private BigDecimal mobilemoneydebittransactionAmount;
    private int mobilemoneydebittransactionNumber ;
    private BigDecimal monthlyBalance ;
    private BigDecimal monthlydebittransactionsAmount ;
    private BigDecimal outgoinginttransactiondebitAmount ;
    private int outgoinginttrndebitNumber;
    private BigDecimal outgoinglocaltransactiondebitAmount ;
    private int outgoinglocaltransactiondebitNumber ;
    private BigDecimal overdraftLimit ;
    private BigDecimal overthecounterwithdrawalsAmount ;
    private int overthecounterwithdrawalsNumber ;
    private BigDecimal transactionValue ;
    private long updatedAt ;
}