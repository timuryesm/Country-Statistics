# 📊 DataGraph Insight

A Java-based data analytics visualization platform that allows users to import datasets, analyze trends, and generate real-time graphical insights.  
It simulates the behavior of a lightweight data intelligence dashboard, focusing on **data parsing**, **multi-threaded analytics**, and **dynamic visualization**.

---

## 🧠 Project Overview

**DataGraph Insight** was developed as an academic software engineering project.  
Its goal was to build an interactive application where users can:

- Upload structured data (e.g., CSV or database exports).  
- Perform multiple concurrent statistical analyses using threads.  
- Visualize processed results as bar charts, line graphs, and trend summaries.  
- Interact with dashboards for real-time data interpretation.

The system emphasizes modularity, maintainability, and concurrent data handling, showcasing strong object-oriented and design-pattern practices.

---

## 🧩 System Architecture
DataGraphInsight/
├── analysism.java            # Main analytics controller orchestrating all threads and analysis tasks
├── analysisth1.java          # Thread 1 – handles average value computation for dataset columns
├── analysisth2.java          # Thread 2 – performs minimum/maximum detection in datasets
├── analysisth3.java          # Thread 3 – computes variance and standard deviation for metrics
├── analysisth4.java          # Thread 4 – calculates moving averages for time-based series
├── analysisth5.java          # Thread 5 – performs correlation analysis between data attributes
├── analysisth6.java          # Thread 6 – identifies outliers and anomalies in datasets
├── analysisth7.java          # Thread 7 – computes regression or trend-line predictions
├── analysisth8.java          # Thread 8 – aggregates summary statistics for final visualization
├── country.java              # Represents a country or region object (metadata for dataset grouping)
├── dataseris.java            # Data model class storing parsed values and associated labels
├── dashboad.java             # Main GUI dashboard displaying visualized results
├── Getdata.java              # Handles dataset import and preprocessing logic
├── loginpage.java            # Authentication UI for user login access
├── mainpage.java             # Primary navigation hub connecting login, upload, and dashboard
└── … (supporting visualization and utility components)

---

## ⚙️ Core Features

### 1. Multi-threaded Data Analysis
- Eight analysis threads (`analysisth1`–`analysisth8`) handle different computation types simultaneously.  
- Ensures responsive performance and parallel statistical computation.

### 2. Data Loading and Preprocessing
- `Getdata.java` handles parsing and normalization of imported datasets.  
- Supports CSV and text-based structured data for analysis readiness.

### 3. Interactive Visualization Dashboard
- `dashboad.java` (GUI) provides an interactive display of processed results.  
- Visuals update dynamically when new analyses complete.

### 4. User Authentication & Navigation
- `loginpage.java` manages login credentials and access control.  
- `mainpage.java` connects core UI modules for smooth navigation.

### 5. Analytical Models
- Includes mean, median, variance, trend-line, and correlation modules.  
- Each algorithm encapsulated within its dedicated threaded class.

---

## 🧰 Prerequisites

- **Java JDK 8 or higher**  
- **JavaFX / Swing** for GUI (depending on version)  
- Basic dataset in `.csv` or `.txt` format for testing

---

📄 License

This project is distributed for educational and non-commercial use under the MIT License.

⸻

🧾 In Summary

DataGraph Insight demonstrates how multi-threading, modular architecture, and visualization can transform raw datasets into actionable insights.
By combining computational analysis with a user-friendly interface, it provides a foundation for more advanced data science applications — bridging the gap between data engineering and analytics in a lightweight Java environment.
