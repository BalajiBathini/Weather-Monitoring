# Project Documentation: Real-Time Data Processing System for Weather Monitoring with Rollups and Aggregates

## 1. Project Overview
The **Real-Time Data Processing System** monitors weather conditions using real-time data from the OpenWeatherMap API. It processes the data to provide summarized insights through rollups and aggregates, including daily weather summaries, temperature conversions, alerting thresholds, and visualizations.

- **Backend**: Built using Spring Boot to process weather data.
- **Database**: PostgreSQL to store daily weather summaries.
- **Frontend**: React with Vite to display weather visualizations.

## 2. System Components
- **Backend**: Spring Boot for RESTful APIs.
- **Database**: PostgreSQL for storing weather data and daily summaries.
- **Frontend**: React + Vite for rendering visualizations and user interaction.
- **Testing**: Postman for API testing.

## 3. Setup and Installation Guide

### Prerequisites
- Java 17+
- PostgreSQL (any version)
- Node.js (version 16+)
- Postman (optional but recommended)
- OpenWeatherMap API key (Sign up at [OpenWeatherMap](https://openweathermap.org/))

### Backend Setup (Spring Boot)
1. Clone the repository:
   ```bash
   git clone https://github.com/BalajiBathini/WeatherMonitoring.git
   cd wm-backend
   ```

2. Update `application.properties` with PostgreSQL and OpenWeatherMap API configuration:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/weather_db
   spring.datasource.username=your_db_username
   spring.datasource.password=your_db_password
   openweathermap.api.key=your_api_key
   ```

3. Build and run the Spring Boot application:
   ```bash
   ./mvnw clean install
   ./mvnw spring-boot:run
   ```

### Database Setup (PostgreSQL)
1. Create a PostgreSQL database:
   ```sql
   CREATE DATABASE weather_db;
   ```
2. The Spring Boot application will automatically generate the necessary tables using JPA Hibernate.

### Frontend Setup (React + Vite)
1. Navigate to the frontend directory:
   ```bash
   cd ../frontend
   ```

2. Install dependencies:
   ```bash
   npm install
   ```

3. Run the development server:
   ```bash
   npm run dev
   ```

## 4. Testing with Postman
- Use Postman to test the API endpoints. Import the Postman collection (if provided) or manually create requests.
- Ensure backend connectivity and data retrieval functionality works as expected.

## 5. Process Flow
1. **API Data Retrieval**: Spring Boot application fetches real-time weather data at configurable intervals (e.g., every 5 minutes).
2. **Temperature Conversion**: Convert temperatures from Kelvin to Celsius or Fahrenheit.
3. **Daily Summaries**: Aggregated weather data includes average, maximum, and minimum temperatures.
4. **Threshold Alerts**: User-defined thresholds trigger alerts (e.g., temperature exceeds 35°C).
5. **Data Storage**: Daily summaries stored in PostgreSQL for analysis.
6. **Visualizations**: The frontend displays summaries and alerts.

## 6. Functionality Overview (Java Spring Boot)
- **Weather Data Retrieval**: Retrieves weather data from the OpenWeatherMap API using `RestTemplate`.
- **Temperature Conversion**: Utility function for converting temperature based on user preferences.
- **Daily Weather Aggregation**: Processes data to generate daily weather insights.
- **Threshold Alerting**: Monitors for alerts when thresholds are exceeded.

## 7. Tools and Dependencies
- **Backend**:
  - Spring Boot (REST APIs)
  - Spring Web, Spring Data JPA (database interaction)
  - PostgreSQL Driver (database connection)
  - Lombok (for reducing boilerplate code)
  
- **Frontend**:
  - React + Vite (frontend UI and visualizations)

- **Database**: PostgreSQL for storing weather summaries.
- **Testing**: Postman for API testing.

## 8. Instructions for Running the System
1. Start PostgreSQL and ensure the database is running.
2. Run the Spring Boot backend as per backend setup instructions.
3. Start the React + Vite frontend to visualize weather data.
4. Use Postman to simulate API requests and test the backend.

## 9. Conclusion
This project implements a real-time weather monitoring system using **Spring Boot**, **PostgreSQL**, and **React**. It efficiently processes weather data for major cities, generates daily summaries, triggers alerts based on thresholds, and visualizes trends. Its modular design and modern frameworks make it scalable and extensible for future enhancements.
