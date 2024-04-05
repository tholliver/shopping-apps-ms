import { PORT } from './config/index.js'
import express from 'express'
import customerRouter from './api/customer.js'
const app = express()

app.use('/', (req, res, next) => {
  // res.status(200).json('hello from customer')
  console.log('h')
  next()
})

customerRouter(app)

app.listen(PORT, () => {
  console.log(`Customers server running on: http://localhost:${PORT}`)
})
// .on('error').on('close', ()=>{
//   c
// })
