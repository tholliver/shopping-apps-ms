import { CustomerService } from '../services/customer-service.js'

export default function customerRouter(app) {
  const service = new CustomerService()

  //   const service = new CustomerService()

  app.get('/:id', async (req, res, next) => {
    console.log('hello in the endo')

    const { id } = req.params
    const data = await service.getDetails(id)
    console.log(data)
    return res.json(data)
  })
}
