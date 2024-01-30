package report_main.reportHandler.actors

import common.types.ID

import java.util.UUID

sealed trait Message[+_]

// Common
case class HandleExistedDocuments() extends Message[Unit]

case class DocumentCreated(uuid: UUID, kbId: ID) extends Message[Unit]

case class ConceptCreated(uuid: UUID, kbId: ID) extends Message[Unit]

case class LinkCreated(uuid: UUID, kbId: ID) extends Message[Unit]

// ConceptActor
case class CreateConcepts() extends Message[Unit]

case class HandleExistedConcepts() extends Message[Unit]


// LinkActor
case class HandleExistedLinks() extends Message[Unit]

case class CreateLinksForExistedConcepts() extends Message[Unit]


// ConceptPropertyActor
case class HandleExistedConceptProperties() extends Message[Unit]

case class CreatePropertiesForExistedConcepts() extends Message[Unit]


// LinkPropertyActor
case class HandleExistedLinkProperties() extends Message[Unit]

case class CreatePropertiesForExistedLinks() extends Message[Unit]


case object ReadyToShutdown extends Message[Unit]
