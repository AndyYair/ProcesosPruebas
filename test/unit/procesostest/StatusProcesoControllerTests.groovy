package procesostest



import org.junit.*
import grails.test.mixin.*

@TestFor(StatusProcesoController)
@Mock(StatusProceso)
class StatusProcesoControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/statusProceso/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.statusProcesoInstanceList.size() == 0
        assert model.statusProcesoInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.statusProcesoInstance != null
    }

    void testSave() {
        controller.save()

        assert model.statusProcesoInstance != null
        assert view == '/statusProceso/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/statusProceso/show/1'
        assert controller.flash.message != null
        assert StatusProceso.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/statusProceso/list'

        populateValidParams(params)
        def statusProceso = new StatusProceso(params)

        assert statusProceso.save() != null

        params.id = statusProceso.id

        def model = controller.show()

        assert model.statusProcesoInstance == statusProceso
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/statusProceso/list'

        populateValidParams(params)
        def statusProceso = new StatusProceso(params)

        assert statusProceso.save() != null

        params.id = statusProceso.id

        def model = controller.edit()

        assert model.statusProcesoInstance == statusProceso
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/statusProceso/list'

        response.reset()

        populateValidParams(params)
        def statusProceso = new StatusProceso(params)

        assert statusProceso.save() != null

        // test invalid parameters in update
        params.id = statusProceso.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/statusProceso/edit"
        assert model.statusProcesoInstance != null

        statusProceso.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/statusProceso/show/$statusProceso.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        statusProceso.clearErrors()

        populateValidParams(params)
        params.id = statusProceso.id
        params.version = -1
        controller.update()

        assert view == "/statusProceso/edit"
        assert model.statusProcesoInstance != null
        assert model.statusProcesoInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/statusProceso/list'

        response.reset()

        populateValidParams(params)
        def statusProceso = new StatusProceso(params)

        assert statusProceso.save() != null
        assert StatusProceso.count() == 1

        params.id = statusProceso.id

        controller.delete()

        assert StatusProceso.count() == 0
        assert StatusProceso.get(statusProceso.id) == null
        assert response.redirectedUrl == '/statusProceso/list'
    }
}
