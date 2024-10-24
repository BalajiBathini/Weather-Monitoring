import axios from 'axios';

// Ideally, use environment variables to store API URLs
const API_URL = 'http://localhost:8080/api/weather'; 

export const fetchWeatherSummaries = async (city) => {
    try {
        // Make the API call to fetch weather summaries for a specific city
        const response = await axios.get(`${API_URL}/summaries/${city}`);
        return response.data; // Return the weather data
    } catch (error) {
        console.error(`Error fetching weather summaries for ${city}:`, error.message);
        throw new Error('Could not fetch weather data. Please try again later.');
    }
};
