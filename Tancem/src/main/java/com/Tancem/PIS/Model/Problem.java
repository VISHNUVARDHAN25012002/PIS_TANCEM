package com.Tancem.PIS.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "problem")

public class Problem {

        @Id
        private int id;

        //@Column(name = "problem", nullable = false, length = 45)
        private String problem;

        @ManyToOne
        @JoinColumn(name = "plant_department_id", nullable = false)
        private PlantDepartment plantDepartment;

    // Getters and Setters

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getProblem() {
            return problem;
        }

        public void setProblem(String problem) {
            this.problem = problem;
        }
    }


