package model.graphql

import caliban.GraphQL.graphQL
import caliban.schema.GenericSchema
import caliban.{GraphQL, RootResolver}
import UploadDocumentsSchema.{uploadDocumentsMutations, uploadDocumentsQueries}
import Dependencies.Dependencies

object RootSchema extends GenericSchema[Dependencies] {
    // Do not remove this imports

    import common.types.ID._
//    import model.graphql.types.UnixTime._
    import model.graphql.types.State._

    lazy val rootSchema: GraphQL[Dependencies] = graphQL(RootResolver(queryResolver = uploadDocumentsQueries, mutationResolver = uploadDocumentsMutations))

    lazy val apiSchema: GraphQL[Dependencies] = rootSchema.rename(
        queriesName = Some("Query"),
        mutationsName = Some("Mutation")
    )
}
