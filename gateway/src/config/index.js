import dotenv from 'dotenv'

dotenv.config()

// Checking NODE_ENV case-insensitively
if (process.env.NODE_ENV && process.env.NODE_ENV.toLowerCase() !== 'prod') {
  const configFile = `../../.env${process.env.NODE_ENV}`
  dotenv.config({ path: configFile }) // Load custom .env file
} else {
  dotenv.config() // Load default .env file
}

// Extracting environment variables
const { PORT, APP_SECRET } = process.env

// Exporting environment variables
export { PORT, APP_SECRET }
