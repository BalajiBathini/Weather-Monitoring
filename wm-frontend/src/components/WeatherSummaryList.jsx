// src/components/WeatherSummaryList.jsx

import { useEffect, useState } from 'react';
import { fetchWeatherSummaries } from '../api/weatherApi';
import WeatherSummary from './WeatherSummary';
import WeatherChart from './WeatherChart';  // Import the WeatherChart component

const WeatherSummaryList = ({ city }) => {
    const [summaries, setSummaries] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);
    const [unit, setUnit] = useState('C');  // State to track temperature unit (Celsius or Fahrenheit)

    useEffect(() => {
        const getWeatherSummaries = async () => {
            setLoading(true);
            setError(null);
            try {
                const data = await fetchWeatherSummaries(city);
                setSummaries(data);
            } catch (err) {
                setError('Failed to fetch weather summaries');
            } finally {
                setLoading(false);
            }
        };

        getWeatherSummaries();
    }, [city]);

    const toggleUnit = () => {
        setUnit(unit === 'C' ? 'F' : 'C');
    };

    if (loading) return <p>Loading...</p>;
    if (error) return <p>{error}</p>;

    return (
        <div className="weather-summary-list">
            <div className="toggle-container text-end">
                <button onClick={toggleUnit}>
                    Switch to °{unit === 'C' ? 'F' : 'C'}
                </button>
            </div>
            {summaries.map((summary) => (
                <WeatherSummary key={summary.date} summary={summary} unit={unit} />
            ))}
            <WeatherChart summaries={summaries} unit={unit} />  {/* Pass the unit to WeatherChart */}
        </div>
    );
};

export default WeatherSummaryList;
