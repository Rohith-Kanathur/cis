# 🌳 CIS – In Memory Depth First Tree Construction of Hierarchical Data in a RDBMS

This project is titled **“In Memory Depth First Tree Construction of Hierarchical Data in a RDBMS.”**  
It enables efficient storage and retrieval of hierarchical data using a **relational database system (RDBMS)**.  

📄 **Paper Link:** [IEEE Xplore – In Memory Depth First Tree Construction of Hierarchical Data in a RDBMS](https://ieeexplore.ieee.org/document/10334098)

---

## 📘 Overview

In the brute-force approach, multiple database hits are required to retrieve the children of a given parent node.  
This operation becomes **expensive and inefficient** as the hierarchy deepens.

To overcome this limitation, the proposed approach retrieves **all descendants of a root node in a single database hit per table** using a **root identifier**.  
This root identifier exists in all tables, ensuring that **only one query per table** is needed.

As a result:
- A **two-level tree** is fetched from the database.
- The **complete hierarchical tree** is then **constructed in memory** using a **depth-first recursive algorithm**.

This significantly reduces the number of database interactions and improves overall performance.

---

## 🧠 Implementation Details

An example used to demonstrate this algorithm was a **College Information System (CIS)**.  
It consists of hierarchical entities such as:

- College  
- Department  
- Faculty  
- Courses  
- Course Instances  
- Students  
- Addresses  

These entities are related to one another through **one-to-one** and **one-to-many** relationships.

### Process

- To retrieve the hierarchical data of a college, all related data is fetched using the **college ID** (the root identifier).  
- The **college ID** exists in all related tables to allow for direct retrieval.  
- Each table also stores **parent information** using:
  - `parent_id`
  - `parent_table_number`
- Retrieved data is stored in a **HashMap of HashMaps** (`Map<Integer, Map<Integer, List<Object>>>`) for quick access.
- The **complete college tree** is then **constructed in memory** using a **depth-first recursive algorithm**.

---

## 🧩 Object-Oriented Design

The project makes extensive use of **object-oriented programming principles**, including:

- **Abstract classes**
- **Encapsulation**
- **Inheritance**
- **Polymorphism**

These design elements ensure modularity, extensibility, and clarity in representing hierarchical entities.

---

## ⚡ Performance Analysis

- Java Date-Time APIs were used to measure execution times for both the brute-force and optimized approaches.  
- The **in-memory approach** demonstrated:
  - **7× improvement** when retrieving 10 records  
  - **25× improvement** when retrieving 20,000 records  

This shows the clear performance benefit of the single-fetch + in-memory reconstruction approach over repeated database hits.

---

## 🧰 Environment, Tools, and Technologies

| Component | Details |
|------------|----------|
| **Programming Language** | Java |
| **Database** | MySQL |
| **Database Access** | JDBC |
| **IDE** | Eclipse (Version 2022-03) |
| **Algorithm** | Recursive Depth First Tree Construction |
| **Paradigm** | Object-Oriented Design |

---

## 📊 Summary

This project presents an **efficient algorithmic solution** for managing hierarchical data in RDBMS environments.  
By combining **single-shot retrieval** with **in-memory recursive tree construction**, it dramatically reduces database I/O and improves performance.  

The concept was formally published and presented at the **IEEE CSITSS Conference 2023**, highlighting its novelty and practical impact.

---
