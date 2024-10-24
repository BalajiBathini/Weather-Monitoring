// src/components/WeatherChart.jsx

import { Line } from 'react-chartjs-2';
import { Chart as ChartJS, LineElement, PointElement, LinearScale, Title, Tooltip, Legend, CategoryScale } from 'chart.js';

// Register necessary components
ChartJS.register(LineElement, PointElement, LinearScale, Title, Tooltip, Legend, CategoryScale);

const WeatherChart = ({ summaries, unit }) => {
    const convertTemp = (temp, unit) => {
        return unit === 'C' ? temp : (temp * 9) / 5 + 32; // Convert to Fahrenheit if necessary
    };

    const labels = summaries.map(summary => summary.date);
    const data = summaries.map(summary => convertTemp(summary.averageTemp, unit));

    const chartData = {
        labels,
        datasets: [
            {
                label: `Average Temperature (°${unit})`,
                data,
                fill: false,
                borderColor: 'rgba(75, 192, 192, 1)',
                tension: 0.1,
            },
        ],
    };

    const options = {
        responsive: true,
        plugins: {
            legend: {
                position: 'top',
            },
            title: {
                display: true,
                text: `Average Temperature Over Time (°${unit})`,
            },
        },
    };

    return (
        <div>
            <Line data={chartData} options={options} />
        </div>
    );
};

export default WeatherChart;
