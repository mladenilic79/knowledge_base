# concern are used for some extra data functionality

# in rails module name & file name must match
module DefaultPageContent
  # default extend for concern
  extend ActiveSupport::Concern

  included do
    # this run before any other controller (same as before_filter)
    before_action :set_page_defaults
  end

  def set_page_defaults
    # can be used in controller or directly in view
    @seo_keywords = "jordan hudgens portfolio"
    @page_title = "sima simic"
  end
end