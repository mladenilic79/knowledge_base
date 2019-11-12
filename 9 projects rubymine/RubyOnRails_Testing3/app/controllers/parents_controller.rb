class ParentsController < ApplicationController

  before_action :set_parent, only: [:show, :edit, :update, :destroy]

  def index
    @parents = Parent.all
  end

  def show
  end

  def new
    @parent = Parent.new

    # showcasing nested/nesting elements in view
    # (model/parent controller/parent_controller 2x, views/parents/_form, views/parent/show)
    # creating space for nesting/nested elements
    3.times { @parent.blogs.build }
  end

  def edit
  end

  def create
    @parent = Parent.new(parent_params)
    respond_to do |format|
      if @parent.save
        format.html { redirect_to parent_path(@parent), notice: 'parent was successfully created.' }
      else
        format.html { render :new }
      end
    end
  end

  def update
    respond_to do |format|
      if @parent.update(parent_params)
        format.html { redirect_to @parent, notice: 'parent was successfully updated.' }
      else
        format.html { render :edit }
      end
    end
  end

  def destroy
    @parent.destroy
    respond_to do |format|
      format.html { redirect_to parents_url, notice: 'parent was successfully destroyed.' }
    end
  end

  private

  def set_parent
    @parent = Parent.find(params[:id])
  end

  def parent_params
    # params.require(:parent).permit(:parent_name, :parent_number)

    # showcasing nested/nesting elements in view (model/parent controller/parent_controller 2x, views/parents/_form)
    # adding permits for nested/nesting elements
    params.require(:parent).permit(:parent_name, :parent_number, blogs_attributes: [:blog_name, :blog_number])
  end

end
