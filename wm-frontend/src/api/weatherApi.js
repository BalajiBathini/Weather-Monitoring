// src/api/weatherApi.js

import axios from 'axios';

const API_URL = 'http://localhost:8080/api/weather'; // Update with your backend API URL

export const fetchWeatherSummaries = async (city) => {
    try {
        const response = await axios.get(`${API_URL}/summaries/${city}`);
        return response.data;
    } catch (error) {
        console.error('Error fetching weather summaries:', error);
        throw error;
    }
};
