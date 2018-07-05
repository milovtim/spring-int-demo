package ru.milovtim

import com.orientechnologies.orient.core.db.ODatabaseSession
import com.orientechnologies.orient.core.db.ODatabaseType
import com.orientechnologies.orient.core.db.OrientDB
import com.orientechnologies.orient.core.db.OrientDBConfig
import com.orientechnologies.orient.core.id.ORID
import com.orientechnologies.orient.core.id.ORecordId
import com.orientechnologies.orient.core.record.OElement
import com.orientechnologies.orient.core.record.impl.ODocument
import com.orientechnologies.orient.core.sql.executor.OResult
import com.orientechnologies.orient.core.sql.executor.OResultSet
import groovy.transform.CompileStatic

@CompileStatic
class Orient {
    static ORID ID = new ORecordId('#17:1')

    static void main(String[] args) {
        def dbFactory = new OrientDB('embedded:/tmp/orient-doc', OrientDBConfig.defaultConfig())
        dbFactory.createIfNotExists('hello', ODatabaseType.PLOCAL)

        def session = dbFactory.open('hello', 'admin', 'admin')

//        session.getClass('SomeClass').createIndex('someId.idx', OClass.INDEX_TYPE.UNIQUE_HASH_INDEX, 'someId')

//        def oclass = session.createClass('SomeClass')
//        oclass.createProperty('someId', OType.INTEGER)
//        oclass.createProperty('someName', OType.STRING)


//        createDoc(session)
//        updateDoc(session)
        queryDoc(session)
//        printDoc(session)

        session.close()
        dbFactory.close()

    }

    static def queryDoc(ODatabaseSession session) {
        OResultSet rs = session.query('SELECT FROM SomeClass WHERE someId = 2')
        rs.collect {OResult or->or.toElement()}.each { OElement el ->
            println(el)
//            println("${el.getProperty('someId')} <--> ${el.getProperty('someName')}")
        }
    }

    static def updateDoc(ODatabaseSession session) {
        ODocument doc = session.load(ID)
        doc.setProperty('someName', 'thirdName')
        doc.save()
    }

    static def printDoc(ODatabaseSession session) {
        def doc = session.load(ID)
        println doc
    }

    static def createDoc(ODatabaseSession session) {
        def element = session.newElement('SomeClass')
        element.setProperty('someId', 2)
        element.setProperty('someName', 'firstName')
        element.save()
        println element
    }
}
