// src/Home.jsx

import { useState } from 'react';
import WeatherSummaryList from './WeatherSummaryList';


const Home = () => {
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
        <div className="container">
            <h1>Weather Monitoring App</h1>
            <select className="form-select form-select-lg my-3 text-center" aria-label=".form-select-lg"
             value={city} onChange={handleChangeCity}>
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

export default Home;
