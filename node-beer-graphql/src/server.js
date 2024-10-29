import { ApolloServer } from "@apollo/server";
import { startStandaloneServer } from "@apollo/server/standalone";

const beers = [
    {asin: "B079V9ZDNY", name: "Drunken Sailor", brewery: "CREW Republic", country: "Germany", abv: 6.4},
    {asin: "B07B2YW1TW", name: "Hop Junkie", brewery: "CREW Republic", country: "Germany", abv: 3.4},
    {asin: "B01AU6LWNC", name: "Edelstoff Exportbier", brewery: "Augustiner Brauerei München", abv: "Germany", Alcohol: 5.6},
];

const typeDefs = `
  type Query {
    allBeers: [Beer]!
    getBeer(asin: String!): Beer
  }

  type Mutation {
    createBeer(asin: String!, name: String!, country: String, abv: Float, brewery: String): Beer
    updateBeer(asin: String!, name: String!, country: String, abv: Float, brewery: String): Beer
    deleteBeer(asin: String!): String
  }

  type Beer {
    asin: String!
    name: String!
    country: String
    abv: Float
    brewery: String
  }

  type Subscription {
    beerUpdated: Beer
  }
`;

const resolvers = {
  Query: {
    allBeers: () => beers,
    getBeer: (_, { asin }) => beers.find((beer) => beer.asin === asin),
  },
  Mutation: {
    updateBeer: (_, { asin, name, country, abv, brewery }) => {
      const beerIndex = beers.findIndex((beer) => beer.asin === asin);
      if (beerIndex === -1) {
        throw new Error("Beer not found");
      }
      beers[beerIndex] = {
        ...beers[beerIndex],
        name,
        country,
        abv,
        brewery,
      };
      return beers[beerIndex];
    },
    deleteBeer: (_, { asin }) => {
      const beerIndex = beers.findIndex((beer) => beer.asin === asin);
      if (beerIndex === -1) {
        throw new Error("Beer not found");
      }
      beers.splice(beerIndex, 1);
      return "Beer deleted successfully";
    },
    createBeer: (_, { asin, name, country, abv, brewery }) => {
      const newBeer = {
        asin,
        name,
        country,
        abv,
        brewery
        };
      beers.push(newBeer);
      return newBeer;
    },
  },
};

const server = new ApolloServer({ typeDefs, resolvers });
const { url } = await startStandaloneServer(server, {
  listen: { port: 4000 },
});
console.log(`🚀  Server ready at: ${url}`);
