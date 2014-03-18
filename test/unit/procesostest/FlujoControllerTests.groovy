package procesostest



import org.junit.*
import grails.test.mixin.*

@TestFor(FlujoController)
@Mock(Flujo)
class FlujoControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/flujo/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.flujoInstanceList.size() == 0
        assert model.flujoInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.flujoInstance != null
    }

    void testSave() {
        controller.save()

        assert model.flujoInstance != null
        assert view == '/flujo/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/flujo/show/1'
        assert controller.flash.message != null
        assert Flujo.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/flujo/list'

        populateValidParams(params)
        def flujo = new Flujo(params)

        assert flujo.save() != null

        params.id = flujo.id

        def model = controller.show()

        assert model.flujoInstance == flujo
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/flujo/list'

        populateValidParams(params)
        def flujo = new Flujo(params)

        assert flujo.save() != null

        params.id = flujo.id

        def model = controller.edit()

        assert model.flujoInstance == flujo
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/flujo/list'

        response.reset()

        populateValidParams(params)
        def flujo = new Flujo(params)

        assert flujo.save() != null

        // test invalid parameters in update
        params.id = flujo.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/flujo/edit"
        assert model.flujoInstance != null

        flujo.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/flujo/show/$flujo.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        flujo.clearErrors()

        populateValidParams(params)
        params.id = flujo.id
        params.version = -1
        controller.update()

        assert view == "/flujo/edit"
        assert model.flujoInstance != null
        assert model.flujoInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/flujo/list'

        response.reset()

        populateValidParams(params)
        def flujo = new Flujo(params)

        assert flujo.save() != null
        assert Flujo.count() == 1

        params.id = flujo.id

        controller.delete()

        assert Flujo.count() == 0
        assert Flujo.get(flujo.id) == null
        assert response.redirectedUrl == '/flujo/list'
    }
}
