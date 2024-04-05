/** @type { import("drizzle-kit").Config } */
export default {
  schema: './src/database/schemas/index.js',
  out: './drizzle/migrations',
  driver: 'pg',
  dbCredentials: {
    connectionString: process.env.DB_URI,
  },
  verbose: true,
  strict: true,
}
