import { PORT } from './config/index.js'

import express from 'express'

const app = express()

app.get('/', (req, res, next) => {
  return res.status(200).json({ msg: 'hello from products' })
})

app.listen(PORT, () => {
  console.log('Products server running on: ', PORT)
})
