import { drizzle } from 'drizzle-orm/postgres-js'
import postgres from 'postgres'
import { DB_URI } from '../config/index.js'
import * as schema from './schemas/index.js'

const queryClient = postgres(DB_URI)
const dbConn = drizzle(queryClient, { schema })

export default dbConn
