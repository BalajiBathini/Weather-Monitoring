// src/App.jsx

import { useState } from 'react';
import WeatherSummaryList from './components/WeatherSummaryList';
import './App.css';

const App = () => {
    const cities = [
        "Delhi", 
        "Jaipur", 
        "Agra", 
        "Varanasi", 
        "Dehradun", 
        "Chandigarh",
        "Mumbai", 
        "Pune", 
        "Ahmedabad", 
        "Surat", 
        "Nagpur",
        "Bangalore", 
        "Chennai", 
        "Hyderabad", 
        "Coimbatore", 
        "Thiruvananthapuram",
        "Kolkata", 
        "Bhubaneswar", 
        "Guwahati", 
        "Patna", 
        "Durgapur",
        "Bhopal", 
        "Indore", 
        "Nagpur", 
        "Shillong", 
        "Imphal", 
        "Agartala", 
        "Aizawl",
        "Srinagar", 
        "Leh", 
        "Puducherry",
        "Mysuru", 
        "Vadodara", 
        "Jodhpur", 
        "Nashik"
    ];

    const [city, setCity] = useState(cities[0]); // Default to the first city

    const handleChangeCity = (event) => {
        setCity(event.target.value);
    };

    return (
        <div className="app">
            <h1>Weather Monitoring App</h1>
            <select value={city} onChange={handleChangeCity}>
                {cities.map((cityName) => (
                    <option key={cityName} value={cityName}>
                        {cityName}
                    </option>
                ))}
            </select>
            <WeatherSummaryList city={city} />
        </div>
    );
};

export default App;
