import { migrate } from 'drizzle-orm/postgres-js/migrator'
import { drizzle } from 'drizzle-orm/postgres-js'
import postgres from 'postgres'
// import { DB_URI } from '../src/config/index.js'
import dbConn from '../src/database/connection.js'
// const migrationsClient = postgres(DB_URI, { max: 1 })

// const db = drizzle(migrationsClient)
await migrate(dbConn, { migrationsFolder: './migrations' })
await dbConn.end()
