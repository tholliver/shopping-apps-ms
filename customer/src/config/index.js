import dotenv from 'dotenv'

dotenv.config()

if (process.env.NODE_ENV && process.env.NODE_ENV.toLowerCase() !== 'prod') {
  const configFile = `../../.env${process.env.NODE_ENV}`
  dotenv.config({ path: configFile }) // Load custom .env file
} else {
  dotenv.config()
}

const { PORT, APP_SECRET, DB_URI } = process.env

export { PORT, APP_SECRET, DB_URI }
