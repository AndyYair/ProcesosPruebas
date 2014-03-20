package procesostest



import org.junit.*
import grails.test.mixin.*

@TestFor(SecFlujoController)
@Mock(SecFlujo)
class SecFlujoControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/secFlujo/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.secFlujoInstanceList.size() == 0
        assert model.secFlujoInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.secFlujoInstance != null
    }

    void testSave() {
        controller.save()

        assert model.secFlujoInstance != null
        assert view == '/secFlujo/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/secFlujo/show/1'
        assert controller.flash.message != null
        assert SecFlujo.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/secFlujo/list'

        populateValidParams(params)
        def secFlujo = new SecFlujo(params)

        assert secFlujo.save() != null

        params.id = secFlujo.id

        def model = controller.show()

        assert model.secFlujoInstance == secFlujo
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/secFlujo/list'

        populateValidParams(params)
        def secFlujo = new SecFlujo(params)

        assert secFlujo.save() != null

        params.id = secFlujo.id

        def model = controller.edit()

        assert model.secFlujoInstance == secFlujo
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/secFlujo/list'

        response.reset()

        populateValidParams(params)
        def secFlujo = new SecFlujo(params)

        assert secFlujo.save() != null

        // test invalid parameters in update
        params.id = secFlujo.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/secFlujo/edit"
        assert model.secFlujoInstance != null

        secFlujo.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/secFlujo/show/$secFlujo.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        secFlujo.clearErrors()

        populateValidParams(params)
        params.id = secFlujo.id
        params.version = -1
        controller.update()

        assert view == "/secFlujo/edit"
        assert model.secFlujoInstance != null
        assert model.secFlujoInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/secFlujo/list'

        response.reset()

        populateValidParams(params)
        def secFlujo = new SecFlujo(params)

        assert secFlujo.save() != null
        assert SecFlujo.count() == 1

        params.id = secFlujo.id

        controller.delete()

        assert SecFlujo.count() == 0
        assert SecFlujo.get(secFlujo.id) == null
        assert response.redirectedUrl == '/secFlujo/list'
    }
}
