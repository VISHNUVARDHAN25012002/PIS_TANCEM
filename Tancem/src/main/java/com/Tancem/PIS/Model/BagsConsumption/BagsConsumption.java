package com.Tancem.PIS.Model.BagsConsumption;

import com.Tancem.PIS.Model.BagsType.BagsType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BagsConsumption {

    @Id
    private int id;


    @NotNull(message = "Transaction date is required.")
    private Date transaction_Date;


   @Column(nullable = false)
    private int opc_Bags;


    @Column(nullable = false)
    private int ppc_Bags;


    @Column(nullable = false)
    private int src_Bag;


    @Column(nullable = false)
    private int no_Of_Export_Bag;


    @Column(nullable = false)
    private int no_Of_Depot_Bags;


    @Column(nullable = false)
    private int no_Of_Brust_Opc_Bags;


    @Column(nullable = false)
    private int no_Of_Brust_Ppc_Bags;


    @Column(nullable = false)
    private int no_Of_Brust_Src_Bags;


    @Column(nullable = false)
    private int transfer_To_Other_Plants;

    @ManyToOne
    @JoinColumn(name = "bags_Type_id", nullable = false)
    private BagsType bagsType;


}