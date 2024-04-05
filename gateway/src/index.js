import { PORT } from './config/index.js'

import cors from 'cors'
import express from 'express'
import proxy from 'express-http-proxy'

const app = express()

app.use(cors())
app.use(express.json())

app.use('/customer', proxy('http://localhost:8001'))
app.use('/shopping', proxy('http://localhost:8003'))
app.use(
  '/spring',
  (req, res, next) => {
    console.log('------------ Calling java on 8080 ------------')
    next()
  },
  proxy('http://localhost:8080')
)
app.use('/', proxy('http://localhost:8002')) // products

app.listen(PORT, () => {
  console.log(`Gateway server running on: http://localhost:${PORT}`)
})
