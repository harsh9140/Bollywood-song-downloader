# 🎵 Bollywood Song Downloader

A Java-based application that crawls Bollywood song information from the web, stores the data in a database, and provides utilities for downloading and managing song information. The project demonstrates concepts such as web crawling, multithreading, database connectivity, and object-oriented programming.

---

## 🚀 Features

- 🌐 Web crawling for Bollywood song data
- 🎵 Read and process song lists
- 💾 Store song information in a database
- 🔄 Multithreaded task execution
- 📂 File handling utilities
- 🗄️ JDBC-based database operations
- 🧩 Modular project structure using Maven

---

## 🛠️ Tech Stack

- Java
- Maven
- JDBC
- PostgreSQL / MySQL (configure as needed)
- JOOQ (generated classes)
- Multithreading
- HTML Parsing / Web Crawling

---

## 📁 Project Structure

```
src/
├── crawler/
├── database/
├── entity/
├── file/
├── threading/
├── generated-sources/
└── Main.java
```

---

## ⚙️ Prerequisites

Before running the project, install:

- Java 8 or later
- Maven
- PostgreSQL or MySQL
- Git

---

## ▶️ Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/harsh9140/Bollywood-song-downloader.git
```

### 2. Open the project

Open the project in IntelliJ IDEA or Eclipse.

### 3. Configure the database

Update the database configuration in the appropriate Java configuration file.

### 4. Install dependencies

```bash
mvn clean install
```

### 5. Run the application

Run:

```
Main.java
```

or

```bash
mvn exec:java
```

---

## 📚 Concepts Demonstrated

- Object-Oriented Programming
- JDBC
- Connection Pooling
- DAO Pattern
- Thread Management
- Runnable Interface
- Singleton Design Pattern
- File Handling
- HTTP URL Connections
- Web Crawling

---

## 👨‍💻 Author

**Harsh Patel**

GitHub: https://github.com/harsh9140

---

## 📄 License

This project is for learning and educational purposes.
