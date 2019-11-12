class ChildrenController < ApplicationController

  before_action :set_child, only: [:show, :edit, :update, :destroy]

  def index
    @children = Child.all
  end

  def show
  end

  def new
    @child = Child.new
  end

  def edit
  end

  def create
    @child = Child.new(child_params)
    respond_to do |format|
      if @child.save
        format.html { redirect_to child_path(@child), notice: 'child was successfully created.' }
      else
        format.html { render :new }
      end
    end
  end

  def update
    respond_to do |format|
      if @child.update(child_params)
        format.html { redirect_to @child, notice: 'child was successfully updated.' }
      else
        format.html { render :edit }
      end
    end
  end

  def destroy
    @child.destroy
    respond_to do |format|
      format.html { redirect_to children_url, notice: 'child was successfully destroyed.' }
    end
  end

  private

  def set_child
    @child = Child.find(params[:id])
  end

  def child_params
    params.require(:child).permit(:child_name, :child_number)
  end

end
