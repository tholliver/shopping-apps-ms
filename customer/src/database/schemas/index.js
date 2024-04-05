import { relations } from 'drizzle-orm'

import {
  integer,
  serial,
  boolean,
  pgTable,
  PrimaryKeyBuilder,
  doublePrecision,
  varchar,
  primaryKey,
} from 'drizzle-orm/pg-core'

export const orders = pgTable('orders', {
  id: serial('id').primaryKey(),
  customerId: integer('customer_id').notNull(),
  status: integer('status').notNull(),
  total: doublePrecision('total').default(10.2),
})

// export const countries = pgTable('countries', {
//   id: integer('id').primaryKey(),
//   name: varchar('name', { length: 255 }).notNull(),
// })

export const addresses = pgTable('addresses', {
  id: serial('id').primaryKey(),
  street: varchar('street', { length: 255 }).notNull(),
  postalcode: varchar('postalcode', { length: 255 }).notNull(),
  // countryId: integer('country_id').notNull(),
  country: varchar('country', { length: 255 }).notNull(),
  customerId: integer('customer_id').notNull(),
})

export const customers = pgTable('customers', {
  id: serial('id').primaryKey(),
  email: varchar('email', { length: 255 }).notNull(),
  password: varchar('password', { length: 255 }).notNull(),
  phone: varchar('phone', { length: 255 }).notNull(),
})

export const products = pgTable('products', {
  id: serial('id').primaryKey(),
  name: varchar('name', { length: 255 }).notNull(),
  desc: varchar('desc', { length: 255 }).notNull(),
  type: varchar('type', { length: 255 }).notNull(),
  unit: integer('unit').notNull(),
  price: doublePrecision('price').default(10.2).notNull(),
  available: boolean('available').notNull(),
  supplier: varchar('supplier', { length: 255 }).notNull(),
})

export const product_order = pgTable(
  'products_orders',
  {
    productId: integer('product_id')
      .notNull()
      .references(() => users.id),
    orderId: integer('order_id')
      .notNull()
      .references(() => groups.id),
  },
  (t) => ({
    pk: primaryKey({ columns: [t.userId, t.groupId] }),
  })
)
export const product_orderRelations = relations(product_order, ({ one }) => ({
  product: one(products, {
    fields: [product_order.productId],
    references: [products.id],
  }),
  order: one(orders, {
    fields: [product_order.orderId],
    references: [orders.id],
  }),
}))

export const productsRelations = relations(products, ({ many }) => ({
  product_order: many(product_order),
}))

export const customerRelations = relations(customers, ({ many }) => ({
  orders: many(orders),
}))

export const ordersRelations = relations(orders, ({ many, one }) => ({
  product_order: many(product_order),
  customer: one(customers, {
    fields: [orders.customerId],
    references: [customers.id],
  }),
}))

export const wishlist = pgTable(
  'wishlist',
  {
    productId: integer('product_id')
      .notNull()
      .references(() => products.id),
    customerId: integer('customer_id')
      .notNull()
      .references(() => customers.id),
  },
  (t) => ({
    pk: primaryKey({ columns: [t.customerId, t.productId] }),
  })
)

export const productsWishlistRelations = relations(customers, ({ many }) => ({
  wishlist: many(wishlist),
}))

export const customerWishlistRelations = relations(products, ({ many }) => ({
  wishlist: many(wishlist),
}))

export const wishlistRelations = relations(wishlist, ({ one }) => ({
  product: one(products, {
    fields: [wishlist.productId],
    references: [products.id],
  }),
  customer: one(customers, {
    fields: [wishlist.customerId],
    references: [customers.id],
  }),
}))
