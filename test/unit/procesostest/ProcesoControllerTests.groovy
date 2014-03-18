package procesostest



import org.junit.*
import grails.test.mixin.*

@TestFor(ProcesoController)
@Mock(Proceso)
class ProcesoControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/proceso/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.procesoInstanceList.size() == 0
        assert model.procesoInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.procesoInstance != null
    }

    void testSave() {
        controller.save()

        assert model.procesoInstance != null
        assert view == '/proceso/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/proceso/show/1'
        assert controller.flash.message != null
        assert Proceso.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/proceso/list'

        populateValidParams(params)
        def proceso = new Proceso(params)

        assert proceso.save() != null

        params.id = proceso.id

        def model = controller.show()

        assert model.procesoInstance == proceso
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/proceso/list'

        populateValidParams(params)
        def proceso = new Proceso(params)

        assert proceso.save() != null

        params.id = proceso.id

        def model = controller.edit()

        assert model.procesoInstance == proceso
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/proceso/list'

        response.reset()

        populateValidParams(params)
        def proceso = new Proceso(params)

        assert proceso.save() != null

        // test invalid parameters in update
        params.id = proceso.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/proceso/edit"
        assert model.procesoInstance != null

        proceso.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/proceso/show/$proceso.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        proceso.clearErrors()

        populateValidParams(params)
        params.id = proceso.id
        params.version = -1
        controller.update()

        assert view == "/proceso/edit"
        assert model.procesoInstance != null
        assert model.procesoInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/proceso/list'

        response.reset()

        populateValidParams(params)
        def proceso = new Proceso(params)

        assert proceso.save() != null
        assert Proceso.count() == 1

        params.id = proceso.id

        controller.delete()

        assert Proceso.count() == 0
        assert Proceso.get(proceso.id) == null
        assert response.redirectedUrl == '/proceso/list'
    }
}
